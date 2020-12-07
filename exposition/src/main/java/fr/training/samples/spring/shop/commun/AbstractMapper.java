package fr.training.samples.spring.shop.commun;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Abstract implementation of a bean mapper
 *
 * @param <T>
 *            The source class
 * @param <S>
 *            The target class
 *
 * @author 472957
 */
public abstract class AbstractMapper<T, S> {

    /**
     * @param entity
     *            entity
     * @return the mapped entity
     */
    public abstract T mapToDto(S entity);

    /**
     * @param dto
     *            dto
     * @return the mapped entity
     */
    public abstract S mapToEntity(T dto);

    /**
     * @param entityList
     *            entityList
     * @return a List of the mapped entity
     */
    public List<T> mapToDtoList(final List<S> entityList) {
        final List<T> dtos = new ArrayList<>();
        for (final S s : entityList) {
            if (s != null) {
                dtos.add(mapToDto(s));
            }
        }
        return dtos;
    }

    /**
     * @param entityList
     *            entityList
     * @return a Set of the mapped entity
     */
    public Set<T> mapToDtoSet(final Set<S> entityList) {
        return entityList.stream().filter(Objects::nonNull).map(this::mapToDto).collect(Collectors.toSet());
    }

    /**
     * @param dtoList
     *            dtoList
     * @return a List of the mapped entity
     */
    public List<S> mapToEntityList(final List<T> dtoList) {
        return dtoList.stream().filter(Objects::nonNull).map(this::mapToEntity).collect(Collectors.toList());
    }

    /**
     * @param dtoList
     *            dtoList
     * @return a Set of the mapped entity
     */
    public Set<S> mapToEntitySet(final Set<T> dtoList) {
        return dtoList.stream().filter(Objects::nonNull).map(this::mapToEntity).collect(Collectors.toSet());
    }
}
