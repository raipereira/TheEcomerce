package raiper.com.ecomerce.dto.converter.dtoToEntity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import raiper.com.ecomerce.dto.request.CategoryRequest;
import raiper.com.ecomerce.model.Category;

@Component
public class ConverterRequestToCategory implements Converter<CategoryRequest, Category> {

    @Override
    public Category convert(CategoryRequest source) {
        var category = new Category().builder()
                .categoryName(source.categoryName())
                .description(source.description())
                .build();
        return category;
    }


}
