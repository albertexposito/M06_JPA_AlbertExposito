package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
//@NamedQuery(name="PersonaNom", query="SELECT p FROM Persona p WHERE p.nombre=:nombre")})
@NamedQuery(name="Usuari", query="SELECT u FROM Usuari u WHERE u.nombre=:nombre")})
@Table(name = "M6UF2_PERSONES")

public class Usuari implements Serializable{
    
    private static final long serialVersionUID = 1L;


     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuariId")
    private Long id;
    public static final String CONSULTA = "NomUsuari";
    
    @Column(name = "NomUser", length = 50, nullable = false)
    private String nombre;

    @Column(name = "Contrasenya", length = 30, nullable = false)
    private String contrasenya;
    
    
    
    public Usuari(Long id, String nombre, String Contrasenya) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenya = contrasenya;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Usuari other = (Usuari) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
}
