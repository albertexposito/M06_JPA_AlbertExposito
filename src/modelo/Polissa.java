package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;



@Entity
@NamedQueries({
@NamedQuery(name=Polissa.CONSULTA, query="SELECT p FROM Polissa p WHERE p.numPolissa=:numPolissa")})
@Table(name = "Polisses", indexes = {
    @Index(columnList = "prenedor", name ="indexPrenedor")
})

public class Polissa implements Serializable{

    public static final String CONSULTA = "polissaNum";
    
    @Id
    private Long id;

    @Column(name = Polissa.CONSULTA, length = 10)
    private Long numPolissa;
    
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "prenedor")
    private Client prenedor;
    
    @OneToOne (fetch= FetchType.LAZY)
    @JoinColumn(name = "vehicle", nullable = false)   
    private Vehicle vehicle;
    
    @Column(name = "dataInici", nullable = false)
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataInici;
    
    @Column(name = "dataFi", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataFi;
    
    
    private TipusPolissa tipus;
    private double prima;
    
    
    
    private static final long serialVersionUID = 1L;

    //public static final String CONSULTA = "idPolissa";

    public Polissa(Long id, Long numPolissa, Client prenedor, Vehicle vehicle, Calendar dataInici, Calendar dataFi, TipusPolissa tipus, double prima) {
        this.id = id;
        this.numPolissa = numPolissa;
        this.prenedor = prenedor;
        this.vehicle = vehicle;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.tipus = tipus;
        this.prima = prima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumPolissa() {
        return numPolissa;
    }

    public void setNumPolissa(Long numPolissa) {
        this.numPolissa = numPolissa;
    }

    public Client getPrenedor() {
        return prenedor;
    }

    public void setPrenedor(Client prenedor) {
        this.prenedor = prenedor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Calendar getDataInici() {
        return dataInici;
    }

    public void setDataInici(Calendar dataInici) {
        this.dataInici = dataInici;
    }

    public Calendar getDataFi() {
        return dataFi;
    }

    public void setDataFi(Calendar dataFi) {
        this.dataFi = dataFi;
    }

    public TipusPolissa getTipus() {
        return tipus;
    }

    public void setTipus(TipusPolissa tipus) {
        this.tipus = tipus;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Polissa other = (Polissa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


    
    
   
}
