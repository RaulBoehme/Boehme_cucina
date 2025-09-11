package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bebidas")
public class Bebidas {

    @Column(name = "idBebidas")
    private int idBebidas;

    @Column(name = "nomeBebida")
    private String nomeBebida;


    public Bebidas(int idBebidas, String nomeBebida) {
        this.idBebidas = idBebidas;
        this.nomeBebida = nomeBebida;
    }

    //Setters
    public Bebidas setIdBebidas(int idBebidas) {this.idBebidas = idBebidas; return this;}
    public Bebidas setNomeBebida(String nomeBebida) {this.nomeBebida = nomeBebida;
        return this;}


    //Getters
    public String getNomeBebida() {return nomeBebida;}
    public int getIdBebidas() {return idBebidas;}




}
