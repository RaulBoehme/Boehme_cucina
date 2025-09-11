package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pratos")
public class Pratos {

    @Column(name = "idPrato")
    private int idPrato;

    @Column(name = "nomePrato")
    private String nomePrato;

    @Column(name = "ingredientes")
    private String ingredientes;

    @Column(name = "peso")
    private String peso;

    @Column(name = "modoDePreparo")
    private String modoDePreparo;

    public Pratos(int idPrato, String nomePrato, String ingredientes, String peso, String modoDePreparo) {
        this.idPrato = idPrato;
        this.nomePrato = nomePrato;
        this.ingredientes = ingredientes;
        this.peso = peso;
        this.modoDePreparo = modoDePreparo;
    }

    //Setters
    public Pratos setIdPrato(int idPrato) {this.idPrato = idPrato;return this;}
    public Pratos setNomePrato(String nomePrato) {this.nomePrato = nomePrato;return this;}
    public Pratos setIngredientes(String ingredientes) {this.ingredientes = ingredientes;return this;}
    public Pratos setPeso(String peso) {this.peso = peso;return this;}
    public Pratos setModoDePreparo(String modoDePreparo) {this.modoDePreparo = modoDePreparo;return this;}

    // Getters
    public int idPrato() { return idPrato; }
    public String nomePrato() {return nomePrato;}
    public String ingredientes() {return ingredientes;}
    public String peso() {return peso;}
    public String modoDePreparo() {return modoDePreparo;}
}
