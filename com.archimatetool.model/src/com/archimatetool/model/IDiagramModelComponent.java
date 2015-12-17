/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.model;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Model Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.archimatetool.model.IDiagramModelComponent#getDiagramModel <em>Diagram Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.archimatetool.model.IArchimatePackage#getDiagramModelComponent()
 * @model abstract="true"
 * @generated
 */
public interface IDiagramModelComponent extends IIdentifier, ICloneable, IAdapter, INameable {
    /**
	 * Returns the value of the '<em><b>Diagram Model</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Diagram Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Model</em>' reference.
	 * @see com.archimatetool.model.IArchimatePackage#getDiagramModelComponent_DiagramModel()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
	 * @generated
	 */
    IDiagramModel getDiagramModel();
} // IDiagramModelComponent
