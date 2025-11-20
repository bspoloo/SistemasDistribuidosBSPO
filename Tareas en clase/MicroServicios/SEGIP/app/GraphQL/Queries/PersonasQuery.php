<?php

declare(strict_types=1);

namespace App\GraphQL\Queries;

use App\Models\Persona;
use Closure;
use GraphQL\Type\Definition\ResolveInfo;
use GraphQL\Type\Definition\Type;
use Rebing\GraphQL\Support\Facades\GraphQL;
use Rebing\GraphQL\Support\Query;
use Rebing\GraphQL\Support\SelectFields;

class PersonasQuery extends Query
{
    protected $attributes = [
        'name' => 'personas',
        'description' => 'A query',
        'model' => Persona::class
    ];

    public function type(): Type
    {
        return Type::listOf(GraphQL::type('Persona'));
    }

    public function args(): array
    {
        return [
            'id' => ['type' => Type::int()],
            'ci' => ['type' => Type::string()],
            'nombres' => ['type' => Type::string()],
            'primer_apellido' => ['type' => Type::string()],
            'segundo_apellido' => ['type' => Type::string()],
        ];
    }

    public function resolve($root, array $args, $context, ResolveInfo $resolveInfo, Closure $getSelectFields)
    {
        /** @var SelectFields $fields */
        $fields = $getSelectFields();
        $select = $fields->getSelect();
        $with = $fields->getRelations();

        $query = Persona::query()->select($select)->with($with);
        $query->where($args);

        return $query->get();
    }
}
