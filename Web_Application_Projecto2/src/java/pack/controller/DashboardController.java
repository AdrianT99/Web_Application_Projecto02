package pack.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "DashboardController")
@SessionScoped
public class DashboardController implements Serializable {

    public DashboardController() {
    }
    
    public void Catalogo(){
        this.redireccionar("/faces/PaginaProductos.xhtml");
    }
    
    public void Clientes(){
        this.redireccionar("/faces/PaginaClientes.xhtml");
        
    }
    
    public void Ventas(){
         this.redireccionar("/faces/PaginaClientes.xhtml");
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
