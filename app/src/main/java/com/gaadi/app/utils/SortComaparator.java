package com.gaadi.app.utils;

import com.gaadi.app.models.SearchcarModel;

import java.util.Comparator;

/**
 * Created by kanishroshan on 4/4/16.
 */
public class SortComaparator implements Comparator<SearchcarModel> {


    public static final int SORT_BY_PRICE_ASC = 1;
    public static final int SORT_BY_PRICE_DESC = 2;
    public static final int SORT_BY_KM_ASC = 3;
    public static final int SORT_BY_KM_DESC = 4;
    public static final int SORT_BY_YEAR_ASC = 5;
    public static final int SORT_BY_YEAR_DESC = 6;
    private final int type;

    public SortComaparator(int type) {
        this.type = type;
    }

    @Override
    public int compare(SearchcarModel lhs, SearchcarModel rhs) {
        switch (type) {
            case SortComaparator.SORT_BY_PRICE_ASC: {
                return ((Long) lhs.getPrice()).compareTo(rhs.getPrice());

            }
            case SortComaparator.SORT_BY_PRICE_DESC: {
                return ((Long) rhs.getPrice()).compareTo(lhs.getPrice());
            }
            case SortComaparator.SORT_BY_KM_ASC: {
                return ((Long) lhs.getKiloMeter()).compareTo(rhs.getKiloMeter());
            }
            case SortComaparator.SORT_BY_KM_DESC: {
                return ((Long) rhs.getKiloMeter()).compareTo(lhs.getKiloMeter());
            }
            case SortComaparator.SORT_BY_YEAR_ASC: {
                return ((Long) lhs.getYear()).compareTo(rhs.getYear());
            }
            case SortComaparator.SORT_BY_YEAR_DESC: {
                return ((Long) rhs.getYear()).compareTo(lhs.getYear());
            }


        }

        return 0;
    }

}
