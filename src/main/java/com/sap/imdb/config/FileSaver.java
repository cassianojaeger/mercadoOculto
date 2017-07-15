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

	public String write(final String baseFolder, final MultipartFile file, final String webContextPath) throws Exception
	{
		final String realPath = webContextPath + baseFolder;
		final String realPath2 = "C:/Users/i857753/workspace/mercadoOculto/src/main/webapp" + baseFolder;
		try
		{
			String path = realPath + "/" + file.getOriginalFilename();
			file.transferTo(new File(path));
			path = realPath2 + "/" + file.getOriginalFilename();
			file.transferTo(new File(path));

			return baseFolder + "/" + file.getOriginalFilename();
		}
		catch (final IOException e)
		{
			throw new Exception("Error when trying to save file");
		}

	}

}
