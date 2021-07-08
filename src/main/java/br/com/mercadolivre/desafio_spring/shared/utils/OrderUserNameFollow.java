package br.com.mercadolivre.desafio_spring.shared.utils;

import br.com.mercadolivre.desafio_spring.user.dto.FollowDTO;
import br.com.mercadolivre.desafio_spring.shared.validations.exceptions.NotValidOrderTypeException;

import java.util.Comparator;
import java.util.List;

public class OrderUserNameFollow {

    public static List<FollowDTO> execute(String s, List<FollowDTO> listFollow) {
        if (!s.equals("")) {
            if (!s.equals("name_asc") && !s.equals("name_desc"))
                throw new NotValidOrderTypeException();
            if (s.equals("name_asc"))
                listFollow.sort(Comparator.naturalOrder());
            else
                listFollow.sort(Comparator.reverseOrder());
        }
        return listFollow;
    }

}
