package br.com.senai.p2m02.devinsales.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "venda")
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendager")
    @SequenceGenerator(name = "vendager", sequenceName = "venda_id_seq", allocationSize = 1)

    private Long id;

    @Column (name = "dt_venda")
    private LocalDate dataVenda;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_comprador", referencedColumnName = "id")
    private UserEntity comprador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id")
    private UserEntity vendedor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public UserEntity getComprador() {
        return comprador;
    }

    public void setComprador(UserEntity comprador) {
        this.comprador = comprador;
    }

    public UserEntity getVendedor() {
        return vendedor;
    }

    public void setVendedor(UserEntity vendedor) {
        this.vendedor = vendedor;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
}