package raiper.com.ecomerce.dto.converter.entityToDto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import raiper.com.ecomerce.dto.response.CategoryResponse;
import raiper.com.ecomerce.dto.response.CategoryResponse2;
import raiper.com.ecomerce.model.Category;

@Component
public class ConverterCategoryToDto2 implements Converter<Category, CategoryResponse2> {

    @Override
    public CategoryResponse2 convert(Category source) {

        var categoryResponse = new CategoryResponse2(source.getCategoryId(),
                source.getCategoryName(),
                source.getDescription());
        return categoryResponse;
    }
}
