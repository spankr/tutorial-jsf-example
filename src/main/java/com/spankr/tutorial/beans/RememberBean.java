/**
 *
 */
package com.spankr.tutorial.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * This is a session scoped bean. One will be created for every active session.
 * (ie, each browser started up)
 *
 * @author lee_vettleson
 *
 */
@ManagedBean(name = "remember")
@SessionScoped
public class RememberBean {

    private static int counter = 0;
    private int id;

    public RememberBean() {
        counter++;
        id = counter;
        System.out.println("Creating a RememberBean #" + id);
    }

    public String getId() {
        return "remember." + id;
    }
}
