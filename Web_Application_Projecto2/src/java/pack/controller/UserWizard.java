
package pack.controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.FlowEvent;
import pack.service.ServicioCliente;
import pack.service.User;

@ManagedBean(name = "UserWizardController")
@ViewScoped
public class UserWizard implements Serializable
{
    private User user = new User();

    private boolean skip;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void save() {
        String pass = user.getPassword();
        String confirmPass = user.getConfirmPassword();
        
        if(pass.equals(confirmPass))
        {
            FacesMessage msg = new FacesMessage("Cuenta creada correctamente!", "Bienvenid@ :" + user.getFirstname());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_WARN, "Campos invalidos", "Las contrasennas no coinciden"));
        }
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false; //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
    public void ingresar() {

            this.redireccionar("/faces/RegistoUsuario.xhtml");

    }

    public void redireccionar(String ruta) {

        HttpServletRequest request;

        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + ruta);
        } catch (Exception e) {

        }
    }
}
