package cat.itacademy.barcelonactiva.munoz.rosario.s05.t01.n01.model.dto;

import java.util.*;

public class SucursalDTO {

    private Long id;
    private String nombreSucursal;
    private String paisSucursal;
    private String tipoSucursal;

    public Long getId() {
        return id;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public String getTipoSucursal() {
        return tipoSucursal;
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

    public void setTipoSucursal(String paisSucursal) {

        List<String> paisesUE = Arrays.asList(new String[]{"Alemania", "Bélgica", "Croacia", "Dinamarca", "España", "Francia", "Irlanda", "Letonia",
                "Luxemburgo", "Países Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia",
                "Malta", "Polonia", "República Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungría",
                "Italia", "Lituania", "Portugal", "Rumanía"});

        if(paisesUE.contains(paisSucursal)){
            this.tipoSucursal = "UE";
        }else{
            this.tipoSucursal = "Fuera UE";
        }
    }

}
