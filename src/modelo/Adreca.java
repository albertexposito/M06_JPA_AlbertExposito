package modelo;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table (name = "Adreces")
public class Adreca {

    private static final long serialVersionUID = 1L;
    
    
    private String carrer;
    private int numero;
    private String poblacio;

    public Adreca(String carrer, int numero, String poblacio) {
        this.carrer = carrer;
        this.numero = numero;
        this.poblacio = poblacio;
    }

    public Adreca() {
    }

    
    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }
    
    
    
    
    
        
}
