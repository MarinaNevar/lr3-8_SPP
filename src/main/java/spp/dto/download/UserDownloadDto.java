package spp.dto.download;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by admin on 07.05.2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDownloadDto {
    private String userName = StringUtils.EMPTY;
    private List<ResumeDownloadDto> resumes = Collections.emptyList();
}
