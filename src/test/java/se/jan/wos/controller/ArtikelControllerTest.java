package se.jan.wos.controller;

import se.jan.wos.model.Artikel;
import se.jan.wos.repository.ArtikelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ArtikelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ArtikelRepository artikelRepository;

    @BeforeEach
    void rensaData() {
        artikelRepository.deleteAll();
    }

    @Test
    void skapaArtikel_returnerarSkapadArtikel() throws Exception {
        String json = """
                {
                    "namn": "Skruv M6",
                    "sku": "ART-001",
                    "pris": 12.5
                }
                """;

        mockMvc.perform(post("/artiklar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.namn").value("Skruv M6"))
                .andExpect(jsonPath("$.sku").value("ART-001"));
    }

    @Test
    void hamtaAllaArtiklar_returnerarListaMedSparadArtikel() throws Exception {
        Artikel artikel = new Artikel();
        artikel.setNamn("Mutter M6");
        artikel.setSku("ART-002");
        artikel.setPris(5.0);
        artikelRepository.save(artikel);

        mockMvc.perform(get("/artiklar"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].namn").value("Mutter M6"));
    }

    @Test
    void hamtaArtikelSomInteFinns_returnerarNotFound() throws Exception {
        mockMvc.perform(get("/artiklar/999"))
                .andExpect(status().isNotFound());
    }
}