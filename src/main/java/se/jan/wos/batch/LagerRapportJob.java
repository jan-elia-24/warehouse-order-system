package se.jan.wos.batch;

import se.jan.wos.repository.LagerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LagerRapportJob {

    private static final Logger log = LoggerFactory.getLogger(LagerRapportJob.class);

    @Autowired
    private LagerRepository lagerRepository;

    @Scheduled(fixedRate = 30000)
    public void korRapport() {
        long antalLagerposter = lagerRepository.count();
        log.info("Batch-jobb: Lagerrapport körd. Antal lagerposter i systemet: {}", antalLagerposter);

        lagerRepository.findAll().forEach(lager -> {
            if (lager.getAntal() != null && lager.getAntal() < 5) {
                log.warn("Lågt lagersaldo för artikel-id {}: endast {} st kvar",
                        lager.getArtikel() != null ? lager.getArtikel().getId() : "okänd",
                        lager.getAntal());
            }
        });
    }
}