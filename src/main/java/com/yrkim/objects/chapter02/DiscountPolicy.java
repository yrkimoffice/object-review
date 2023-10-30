package main.java.com.yrkim.objects.chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface DiscountPolicy {
//    private List<DiscountCondition> conditions = new ArrayList<>();
//
//    DiscountPolicy(DiscountCondition... conditions) {
//        this.conditions = Arrays.asList(conditions);
//    }

    Money calculateDiscountAmount(Screening screening);

//    abstract Money getDiscountAmount(Screening screening);
}
