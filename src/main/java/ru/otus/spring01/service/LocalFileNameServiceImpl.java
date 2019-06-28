package ru.otus.spring01.service;

import org.springframework.stereotype.Service;
import ru.otus.spring01.Main;
import ru.otus.spring01.settings.AppProps;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LocalFileNameServiceImpl implements LocalFileNameService {
    private final String path;
    private final String language;
    private final String country;

    public LocalFileNameServiceImpl(AppProps appProps) {
        this.path = appProps.getTestfileName();
        this.language = appProps.getLocaleLanguage();
        this.country = appProps.getLocaleCountry();
    }

    @Override
    public URI get() {
        Path pth = Paths.get(path);
        URI uri = Paths.get(path).toUri();

        if (!pth.toFile().exists()) {
            try {
                URL url = Main.class.getClassLoader().getResource(path);
                uri = url.toURI();
            } catch (URISyntaxException | NullPointerException e) {
                System.out.println("Test file not found");
                e.printStackTrace();
                System.exit(888);
            }

        }

        int index = path.lastIndexOf('.');
        String beginPart, endPart;
        if (index != -1) {
            beginPart = path.substring(0, index);
            endPart = path.substring(index);
        } else {
            beginPart = path;
            endPart = "";
        }
        Path probePath = Paths.get(beginPart + "_" + language + "_" + country + endPart);
        if (probePath.toFile().exists()) {
            uri = probePath.toUri();
        } else {
            try {
                URL url = Main.class.getClassLoader().getResource(probePath.toString());
                uri = url.toURI();
            } catch (URISyntaxException | NullPointerException e) {
                System.out.println("Localization not found, then we use default.");
            }

        }
        return uri;
    }
}
