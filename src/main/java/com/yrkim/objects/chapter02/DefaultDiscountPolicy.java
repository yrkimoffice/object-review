package main.java.com.yrkim.objects.chapter02;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return null;
    }
}
