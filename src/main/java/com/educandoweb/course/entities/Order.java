package com.educandoweb.course.entities;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb-order") //fazendo isso eu diferencio o nome da tabela com uma função do sql
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T' HH:mm:ss 'Z'", timezone = "GMT")// aqui estamos formatando o instante para o padrao UTC
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne //aqui eu estou passando as especificações para o banco de dados
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "id.order") //o id tem um pedido, aqui eu digo que um pedido pode ter muitos itens
    private Set<OrderItem> orderItems = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) //aqui estamos mapeando as duas entidades para terem o mesmo id, pois a relação é um para um, o cascade faz algo basicamente assim 'Se eu salvar um Order, salva o Payment junto'
    private Payment payment;

    public Order() {
    }

    public Order(Long id, Instant moment,OrderStatus orderStatus ,User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    //aqui eu estou fazendo tipo um casting, pois meu metodo verifica inteiro e dentro desta minha classe order, eu tenho um Integer orderStatus, isso faz uma verificação de tipo e evita futuros erros de compilação
    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Double getTotal() { //somamos o sub total de cada item e adicionamos a variavel soma, assim retornando o valor total da compra
        double sum = 0;
        for (OrderItem orderItem : orderItems) {
            sum += orderItem.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
