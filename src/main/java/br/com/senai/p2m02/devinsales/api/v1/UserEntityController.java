package br.com.senai.p2m02.devinsales.api.v1;

import br.com.senai.p2m02.devinsales.model.UserEntity;
import br.com.senai.p2m02.devinsales.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserEntityController {

    @Autowired
    private UserEntityService service;

    @PatchMapping ("/{id_user}/feature/{nome_feature}/permissao/{tipo_permissao}")
    public ResponseEntity<Void> patchPermissao(
                        @PathVariable (name="id_user") Long idUser,
                        @PathVariable (name="nome_feature") String nomeFeature,
                        @PathVariable (name="tipo_permissao") String tipoPermissao,
                        @RequestAttribute("loggedUser") UserEntity loggedUser) {
        if (!loggedUser.canWrite("usuario")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        service.patchPermissao(idUser, nomeFeature, tipoPermissao);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
