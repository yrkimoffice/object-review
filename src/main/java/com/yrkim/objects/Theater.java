package main.java.com.yrkim.objects;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        /**
         * 소극장은 관람객의 가방을 열어 초대장이 있는지 확인한다.
         * 초대장이 있으면 판매원은 매표소에 있는 티켓을 관람객의 가방으로 옮긴다.
         */
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        }
        /**
         * 가방에 초대장이 들어있지 않으면 관람객의 가방에서 티켓금액을 꺼낸다.
         * 매표소에 티켓금액을 적립한다.
         * 매표소에 있는 티켓을 관람객의 가방으로 옮긴다.
         */
        else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
