package main.java.com.yrkim.objects.chapter01;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice; //티켓오피스에 대한 접근은 티켓셀러안에서만 존재하게 됨
    }

    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }
}
