package net.com.springboot;

import net.com.springboot.entity.WikiMediaData;
import net.com.springboot.repository.WikiMediaEventDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER=
            LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikiMediaEventDataRepository wikiMediaEventDataRepository;

    public KafkaDatabaseConsumer(WikiMediaEventDataRepository wikiMediaEventDataRepository) {
        this.wikiMediaEventDataRepository = wikiMediaEventDataRepository;
    }

    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "myGroup"
    )
    public void consume(String eventMessage){
       LOGGER.info(String.format("event message --- %s",eventMessage));
        WikiMediaData wikiMediaData = new WikiMediaData();
        wikiMediaData.setWikiEventData(eventMessage);
        wikiMediaEventDataRepository.save(wikiMediaData);
    }
}
