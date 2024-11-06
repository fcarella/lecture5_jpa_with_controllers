package lecture5.jpa.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;


/**
 * @author fcarella
 */
@Entity
public class DiscMag extends Magazine {

    @Basic
    private boolean hasDisc;

    public boolean isHasDisc() {
        return hasDisc;
    }

    public void setHasDisc(boolean hasDisc) {
        this.hasDisc = hasDisc;
    }

    @Override
    public void initialize() {
        super.initialize(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void edit() {
        super.edit(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    

}