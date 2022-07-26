
package pack.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import static org.eclipse.jdt.internal.compiler.env.IModuleAwareNameEnvironment.LookupStrategy.Named;

@ManagedBean(name = "inputNumberView")
@ViewScoped
public class InputNumberView implements Serializable {
    
    private int input1;
    private int input2;
    private int input3;
    private int costoTotal = input1*input2;
  
    public InputNumberView() {
    }

    public InputNumberView(int input1, int input2, int input3) {
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
    }
    
    

    public int getInput1() {
        return input1;
    }

    public void setInput1(int input1) {
        this.input1 = input1;
    }

    public int getInput2() {
        return input2;
    }

    public void setInput2(int input2) {
        this.input2 = input2;
    }

    public int getInput3() {
        return input3;
    }

    public void setInput3(int input3) {
        this.input3 = input3;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }
    
 
    public void calculoCostoTotal() {
        this.input3 = input1*input2;
    }
}
