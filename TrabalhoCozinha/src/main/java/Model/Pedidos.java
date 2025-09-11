package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedidos {

    @Column(name = "idPedido")
    private int idPedido;

    @Column(name = "pratos")
    private Pratos pratos;

    @Column(name = "descricao")
    private String descricao;
}
