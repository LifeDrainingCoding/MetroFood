package com.lifedrained.metrofood.utils;


import com.google.gson.internal.NonNullElementWrapperList;
import com.lifedrained.metrofood.Main;
import com.lifedrained.metrofood.data.repo.PositionRepo;
import com.lifedrained.metrofood.data.repo.entity.Position;
import com.nimbusds.jose.util.StandardCharset;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import oshi.util.FileUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.reflections.Reflections.log;

public class PositionUtils {
    private static final int FIELD_NUMBER = 5;
    public static void updatePositions(PositionRepo repo)  {
        repo.deleteAll();
        ArrayList<Position> positions = new ArrayList<>();

        try {
            String positionsContent = IOUtils.toString(Main.class.getResourceAsStream("/positions.txt"), StandardCharsets.UTF_8);
            positionsContent = positionsContent.replaceAll("\n", "");
            String[] entries = positionsContent.split(";");

            for (String entry : entries) {
                String[] f = entry.split(":");

                if (f.length != FIELD_NUMBER) {
                    log.error("Skipping entry due invalid field number: {}", entry);
                    continue;
                }

                Position position = new Position();
                position.setName(f[0]);
                position.setDescription(f[1]);
                position.setPrice(Double.parseDouble(f[2]));
                position.setCategory(f[3].toUpperCase());
                position.setImgPath(f[4]);
                positions.add(position);
            }

            log.info("successfully rewrote {} entries", repo.saveAll(positions).size());
            Notify.success(String.format("Успешно перезаписано %d позиций",repo.saveAll(positions).size()));

        }catch (Exception ex){

            log.error("Something gone wrong with updating positions: ", ex);
            Notify.error("Ошибка при перезаписи позиций, детали в логах. ");

        }
    }
}
