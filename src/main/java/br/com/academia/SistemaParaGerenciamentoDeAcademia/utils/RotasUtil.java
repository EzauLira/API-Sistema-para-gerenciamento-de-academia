package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.PathsERoles;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.TipoUsuarioEnum;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RotasUtil {

    private static final Logger logger = LoggerFactory.getLogger(RotasUtil.class);

    public static Map<String, List<TipoUsuarioEnum>> pegarRotas(ResourceLoader resourceLoader) {
        Map<String, List<TipoUsuarioEnum>> pathsAndRoles = new HashMap<>();
        Resource resource = resourceLoader.getResource("classpath:rotas.json");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<PathsERoles> rolePathList = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<PathsERoles>>() {
            });
            for (PathsERoles rolePath : rolePathList) {
                pathsAndRoles.put(rolePath.getPath(), rolePath.getRoles());
            }
        } catch (IOException e) {
            logger.error("Erro ao ler o arquivo de rotas: ", e);
            throw new RuntimeException(e);
        }
        return pathsAndRoles;
    }
}