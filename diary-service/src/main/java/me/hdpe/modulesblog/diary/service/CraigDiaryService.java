package me.hdpe.modulesblog.diary.service;

import static com.google.common.base.Preconditions.checkArgument;
import me.hdpe.modulesblog.diary.api.DiaryService;

import org.springframework.cache.annotation.Cacheable;

public class CraigDiaryService implements DiaryService {

	@Override
	@Cacheable("diary-events")
	public String[] getDiaryEvents(int days) {
		checkArgument(days == 7, "Unsupported period");
		
		return new String[] { "met this girl",
				"took her for a drink",
				"making love", "making love",
				"making love", "making love",
				"chilled" };
	}	
}
