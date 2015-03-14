/**
 *
 */
package com.spankr.tutorial.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * This is a Request scoped bean. A new one will be created for each request.
 *
 * @author lee_vettleson
 */
@ManagedBean(name = "quick")
@RequestScoped
public class QuickBean {

    private static int counter = 0;
    private int id;

    public QuickBean() {
        counter++;
        id = counter;
        System.out.println("Creating a QuickBean #" + id);
    }

    public String getId() {
        return "quick." + id;
    }
}
