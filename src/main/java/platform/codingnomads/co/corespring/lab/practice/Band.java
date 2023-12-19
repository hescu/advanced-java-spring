package platform.codingnomads.co.corespring.lab.practice;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
@NoArgsConstructor
public class Band {
    @Autowired
    private Singer singer;
    @Autowired
    private Guitarist guitarist;
    @Autowired
    private Drummer drummer;

    public Band(Singer singer, Guitarist guitarist, Drummer drummer) {
        this.singer = singer;
        this.guitarist = guitarist;
        this.drummer = drummer;
    }
}
