package br.com.senai.p2m02.devinsales.service;

import br.com.senai.p2m02.devinsales.model.VendaEntity;
import br.com.senai.p2m02.devinsales.repository.SpecificationsVendaEntity;
import br.com.senai.p2m02.devinsales.repository.UserEntityRepository;
import br.com.senai.p2m02.devinsales.repository.VendaEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VendaEntityService {

    @Autowired
    private VendaEntityRepository vendaEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Transactional
    public List<VendaEntity> listarVendas(Long idVendedor){
        userEntityRepository.findById(idVendedor).orElseThrow(()->new EntityNotFoundException("Não existe vendedor com ID " +idVendedor));
        return vendaEntityRepository.findAll(Specification.where(
                SpecificationsVendaEntity.idVendedor(idVendedor)
        ));
    }

    @Transactional
    public VendaEntity listarPorId(Long id) {
        return vendaEntityRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Não existe venda " + id)
        );
    }
}