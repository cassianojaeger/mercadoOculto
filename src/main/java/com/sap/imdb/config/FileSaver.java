package com.sap.imdb.config;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileSaver
{

	@Autowired
	private ServletContext servletContext;

	public String write(final String baseFolder, final MultipartFile file) throws Exception
	{
		final String realPath = "C:/Users/i857753/workspace/imdb-master/src/main/webapp" + baseFolder;
		try
		{
			final String path = realPath + "/" + file.getOriginalFilename();
			file.transferTo(new File(path));
			return baseFolder + "/" + file.getOriginalFilename();
		}
		catch (final IOException e)
		{
			throw new Exception("Erro na hora de salvar o arquivo");
		}

	}

}
