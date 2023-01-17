package cat.itacademy.barcelonactiva.munoz.rosario.s05.t01.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name="sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    private String nombreSucursal;
    private String paisSucursal;

    public Long getId() {
        return id;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }
}
