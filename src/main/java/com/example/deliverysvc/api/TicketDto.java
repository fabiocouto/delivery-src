package com.example.deliverysvc.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketDto {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private Long id;
    private LocalDateTime dateTime;
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketDto dto)) return false;

        if (getId() != null ? !getId().equals(dto.getId()) : dto.getId() != null) return false;
        if (getDateTime() != null ? !getDateTime().equals(dto.getDateTime()) : dto.getDateTime() != null) return false;
        return getPrice() != null ? getPrice().equals(dto.getPrice()) : dto.getPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDateTime() != null ? getDateTime().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", price=" + price +
                '}';
    }
}
