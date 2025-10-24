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

class PersonaQuery extends Query
{
    protected $attributes = [
        'name' => 'persona',
        'description' => 'A query'
    ];

    public function type(): Type
    {
        return GraphQL::type('Persona');
    }

    public function args(): array
    {
        return [
            'ci' => [
                'type' => Type::nonNull(Type::string()),
                'description' => 'CI de la persona a buscar',
            ],
        ];
    }

    public function resolve($root, array $args, $context, ResolveInfo $resolveInfo, Closure $getSelectFields)
    {
        /** @var SelectFields $fields */
        $fields = $getSelectFields();
        $select = $fields->getSelect();
        $with = $fields->getRelations();

        //return Persona::find($args['ci']); //para buscar con solo ci
        return Persona::where('ci',$args['ci'])->first();
    }
}
