package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

@Entity

//@NamedQueries({
//@NamedQuery(name="PersonaNom", query="SELECT p FROM Persona p WHERE p.nombre=:nombre")})
//@NamedQuery(name=Vehicle.CONSULTA, query="SELECT p FROM Vehicle p WHERE p.matricula=:matricula")})
@Table(name = "Vehicles", indexes = {
    @Index(columnList = "matricula", name ="indexMatricula")
})

public class Vehicle implements Serializable{

    
    private static final long serialVersionUID = 1L;

     public static final String CONSULTA = "idVehicle";

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleId")
    private Long id;
    
    @Column(name = "Matricula", length = 7, nullable = false, unique=true)
    //@IndexColumn(name="indexMatricula")
    private String matricula;

    @Column(name = "Marca/Model", length = 40)
    private String marcaModel;
    
    
    @Column(name = "Fabricacio", length = 30)
    private int anyFabricacio;
    
    @Column(name = "Propietari", length = 80)
    @Basic(fetch= FetchType.LAZY)
 
    private Client propietari;

    public Vehicle() {
    }

    public Vehicle(Long id, String matrcula, String marcaModel, int anyFabricacio, Client propietari) {
        this.id = id;
        this.matricula = matrcula;
        this.marcaModel = marcaModel;
        this.anyFabricacio = anyFabricacio;
        this.propietari = propietari;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarcaModel() {
        return marcaModel;
    }

    public void setMarcaModel(String marcaModel) {
        this.marcaModel = marcaModel;
    }

    public int getAnyFabricacio() {
        return anyFabricacio;
    }

    public void setAnyFabricacio(int anyFabricacio) {
        this.anyFabricacio = anyFabricacio;
    }

    public Client getPropietari() {
        return propietari;
    }

    public void setPropietari(Client propietari) {
        this.propietari = propietari;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
   
}
