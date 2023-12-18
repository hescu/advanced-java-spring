package platform.codingnomads.co.corespring.lab.practice;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@NoArgsConstructor
public class Band {
    private Singer singer;
    private Guitarist guitarist;
    private Drummer drummer;

    public Band(Singer singer, Guitarist guitarist, Drummer drummer) {
        this.singer = singer;
        this.guitarist = guitarist;
        this.drummer = drummer;
    }
}
