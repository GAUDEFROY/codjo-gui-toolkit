/*
 * Team : AGF AM / OSI / SI / BO
 *
 * Copyright (c) 2001 AGF Asset Management.
 */
package net.codjo.gui.toolkit.wizard;
import java.beans.PropertyChangeListener;
import java.util.Map;
import javax.swing.JComponent;
/**
 * Definition d'une �tape.
 *
 * @author $Author: gaudefr $
 * @version $Revision: 1.7 $
 */
public interface Step {
    // -----------------------------------------------------------------------------------------------------------------
    // Event
    // -----------------------------------------------------------------------------------------------------------------
    public static final String FULFILLED_PROPERTY = "fulfilled";

    // -----------------------------------------------------------------------------------------------------------------
    // State
    // -----------------------------------------------------------------------------------------------------------------
    /**
     * Indque si l'�tape est accompli.
     *
     * @return true si accompli.
     */
    public boolean isFulfilled();


    /**
     * Retourne le nom de l'�tape.
     *
     * @return Nom de l'�tape.
     */
    public String getName();


    /**
     * Le composant graphique de cette �tape.
     *
     * @return Le composant d'�dition de cette �tape.
     */
    public JComponent getGui();


    /**
     * D�marre cette �tape.
     *
     * @param previousStepState Etat des pr�c�dentes �tape.
     */
    public void start(Map previousStepState);


    /**
     * Annule et re-initialise cette �tape. Cette methode est appel� lors d'un retour en
     * arri�re.
     */
    public void cancel();


    /**
     * Retourne l'�tat de l'�tape.
     *
     * @return une map.
     */
    public Map<String, Object> getState();


    public void addPropertyChangeListener(String propertyName,
        PropertyChangeListener listener);


    public void removePropertyChangeListener(String propertyName,
        PropertyChangeListener listener);
}
