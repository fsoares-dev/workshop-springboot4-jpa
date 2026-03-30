package com.educandoweb.course.entities.enums;

public enum OrderStatus {

    //adicionamos os numeros para caso exista uma futura manuntenção no código, o programador pode adicionar uma opção a mais de enum e assim nao quebramos o banco de dados por conta disso
    WAINTING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELLED(5);

    //isso deve ser feito para nao dar erro nos numeros colocados nas enums
    private int code;
    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    //verifica se o valor é igual a algum valor correspondente dentro do meu OrderStatus
    public static OrderStatus valueOf(int code) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
