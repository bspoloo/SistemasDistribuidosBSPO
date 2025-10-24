<?php

declare(strict_types=1);

namespace App\GraphQL\Mutations;

use App\Models\Persona;
use Closure;
use GraphQL\Type\Definition\ResolveInfo;
use GraphQL\Type\Definition\Type;
use Rebing\GraphQL\Support\Facades\GraphQL;
use Rebing\GraphQL\Support\Mutation;
use Rebing\GraphQL\Support\SelectFields;

class CreatePersonaMutation extends Mutation
{
    protected $attributes = [
        'name' => 'createPersona',
        'description' => 'A mutation'
    ];

    public function type(): Type
    {
        return GraphQL::type('Persona');
    }

    public function args(): array
    {
        return [
            'nombres' => ['type' => Type::nonNull(Type::string())],
            'ci' => ['type' => Type::nonNull(Type::string())],
            'primer_apellido' => ['type' => Type::nonNull(Type::string())],
            'segundo_apellido' => ['type' => Type::nonNull(Type::string())],
        ];
    }

    public function resolve($root, array $args, $context, ResolveInfo $resolveInfo, Closure $getSelectFields)
    {
        $fields = $getSelectFields();
        $select = $fields->getSelect();
        $with = $fields->getRelations();

        $persona = Persona::create($args);
        return $persona;
    }
}
