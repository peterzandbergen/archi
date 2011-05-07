/*******************************************************************************
 * Copyright (c) 2010 Bolton University, UK. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * License which accompanies this distribution in the file LICENSE.txt
 *******************************************************************************/
package uk.ac.bolton.archimate.editor.diagram.actions;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;

/**
 * SelectAllAction including connections
 * 
 * @author Phillip Beauvoir
 */
public class SelectAllAction extends Action {

    private IWorkbenchPart part;

    /**
     * Constructs a <code>SelectAllAction</code> and associates it with the
     * given part.
     * 
     * @param part The workbench part associated with this SelectAllAction
     */
    public SelectAllAction(IWorkbenchPart part) {
        this.part = part;
        setText("&Select All");
        setToolTipText("Select All");
        setId(ActionFactory.SELECT_ALL.getId());
    }

    /**
     * Selects all edit parts and connections in the active workbench part.
     */
    @Override
    public void run() {
        GraphicalViewer viewer = (GraphicalViewer)part.getAdapter(GraphicalViewer.class);
        if(viewer != null) {
            viewer.setSelection(new StructuredSelection(getSelectableEditParts(viewer).toArray()));
        }
    }

    /**
     * Retrieves edit parts which can be selected and their connections
     * 
     * @param viewer from which the edit parts are to be retrieved
     * @return list of selectable EditParts
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private Set getSelectableEditParts(GraphicalViewer viewer) {
        HashSet selectableChildren = new HashSet(); // No duplicates
        
        for(Object child : viewer.getContents().getChildren()) {
            if(child instanceof GraphicalEditPart) {
                GraphicalEditPart childPart = (GraphicalEditPart)child;
                if(childPart.isSelectable() && childPart.getFigure().isVisible()) { // TODO GEF 3.7 no need to check isVisible
                    selectableChildren.add(childPart);
                    // Add connections if selectable
                    for(Object o : childPart.getSourceConnections()) {
                        GraphicalEditPart connectionEditPart = (GraphicalEditPart)o;
                        if(connectionEditPart.isSelectable() && connectionEditPart.getFigure().isVisible()) { // TODO GEF 3.7 no need to check isVisible
                            selectableChildren.add(connectionEditPart);
                        }
                    }
                    for(Object o : childPart.getTargetConnections()) {
                        GraphicalEditPart connectionEditPart = (GraphicalEditPart)o;
                        if(connectionEditPart.isSelectable() && connectionEditPart.getFigure().isVisible()) { // TODO GEF 3.7 no need to check isVisible
                            selectableChildren.add(connectionEditPart);
                        }
                    }
                }
            }
        }
        
        return selectableChildren;
    }

}
