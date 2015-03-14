package com.spankr.tutorial.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.spankr.tutorial.model.User;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    @ManagedProperty(value = "#{userBeanManager}")
    private UserBeanManager userBeanManager;

    private static final long serialVersionUID = -8672427345387220319L;
    protected String firstName = null;
    protected String lastName = null;
    protected Date dob;
    protected String sex = null;
    protected String email = null;
    protected String serviceLevel = "medium";
    protected String answer = null;
    protected Boolean registered = false;

    public UserBean() {
        System.out.println("Creating user bean");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("MM/dd/yyyy");

        return (dateFormat.format(date));

    }

    public void setUserBeanManager(UserBeanManager userBeanManager) {
        this.userBeanManager = userBeanManager;
    }

    public void validateEmail(FacesContext context, UIComponent toValidate,
            Object value) throws ValidatorException {
        String emailStr = (String) value;
        if (-1 == emailStr.indexOf("@")) {
            FacesMessage message = new FacesMessage("Invalid email address");
            throw new ValidatorException(message);
        }
    }

    public void validateDate(FacesContext context, UIComponent toValidate,
            Object value) throws ValidatorException {
        //Date object to compare dob with todays date minus 18 years
        Calendar today = Calendar.getInstance();
        today.add(Calendar.YEAR, -18);
        Date date = (Date) value;

        if (date.after(today.getTime())) {
            FacesMessage message = new FacesMessage("Must be 18 years or older to create a user");
            throw new ValidatorException(message);
        }
    }

    public String addConfirmedUser() {
        // This method would call a database or other service and add the 
        // confirmed user information.
        // For now, we just place an informative message in request scope
        FacesMessage doneMessage = new FacesMessage("Successfully added new user");
        FacesContext.getCurrentInstance().addMessage(null, doneMessage);
        return "done";
    }

    public String userSubmit() {
        if (answer.length() > 200) {
            return "user-failure?face-redirect=true";
        } else {
            userBeanManager.addUser(new User(firstName, lastName, formatDate(dob), sex, email, answer));
            registered = true;

            return "user-success?faces-redirect=true";
        }
    }

    public String[] getGenders() {
        String[] genders = {"Male", "Female", "N/A"};

        return genders;
    }
}
