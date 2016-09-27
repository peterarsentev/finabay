package ru.job4j.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.job4j.service.LimitService;

import javax.servlet.*;
import java.io.IOException;
import java.util.Locale;

/**
 * //TODO add comments
 *
 * @author parsentev
 * @since 21.09.2016
 */
@Component
public class LimitFilter implements Filter {
    private final LimitService service;
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public LimitFilter(final LimitService service) {
        this.service = service;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        Locale locale = req.getLocale();
        if (!this.service.isLimit(locale != null ? locale.getCountry() : "lv")) {
            chain.doFilter(req, res);
        } else {
            res.getOutputStream().write(
                    mapper.writeValueAsBytes(new Error("Exceed execute from this country"))
            );
        }
    }

    @Override
    public void destroy() {
    }
}
