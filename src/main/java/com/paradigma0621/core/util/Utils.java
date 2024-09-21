package com.paradigma0621.core.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;

public class Utils {

    private Utils() { }

    public static PageRequest returnPageable(Pageable pageable) {
        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
    }

    public static String returnOrderAndLimit(Pageable pageable) {
        var ordenation = createQueryOrderBy(pageable);
        var pagination = createQueryPagination(pageable);
        return "\n" + ordenation + "\n" + pagination;
    }

    public static String createQueryOrderBy(Pageable page) {
        final Sort sort = page.getSort();
        if (sort.isUnsorted()) {
            return "";
        }

        final Iterator<Sort.Order> it = sort.iterator();
        final StringBuilder builder = new StringBuilder(" ORDER BY ");
        while(it.hasNext()) {
            final Sort.Order s = it.next();
            builder.append(s.getProperty()).append(" ").append(s.getDirection()).append(" ,");
        }
        builder.setLength(builder.length()-1);
        builder.append(" ");
        return builder.toString();
    }

    public static String createQueryPagination(Pageable page) {
        return String.format(" LIMIT %s,%s ", (page.getPageNumber() * page.getPageSize()), page.getPageSize());
    }
}
