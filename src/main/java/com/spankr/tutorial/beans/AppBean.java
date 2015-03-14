/**
 *
 */
package com.spankr.tutorial.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Application scoped bean. There should only ever be one instance of this bean
 * available. Use 'eager=true' to create this bean at startup.
 *
 * @author lee_vettleson
 *
 */
@ManagedBean(name = "app")
@ApplicationScoped
public class AppBean {

    private static int counter = 0;
    private int id;

    public AppBean() {
        counter++;
        id = counter;
        System.out.println("Creating a AppBean #" + id);
    }

    public String getId() {
        return "app." + id;
    }
}
