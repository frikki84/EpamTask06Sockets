package by.epamtc.jwdmay2020.dziadkouskaya.task06.client.service.parser;

import java.util.List;

import by.epamtc.jwdmay2020.dziadkouskaya.task06.bean.Text;

//interface - layer between dao and service
public interface InfoFromDaoToService {
	public Text returnInformationForTextAnalysis(String string);

}
  