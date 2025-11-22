<?php

declare(strict_types=1);

namespace App\GraphQL\Mutations;

use App\Models\Pronostico;
use Closure;
use GraphQL\Type\Definition\ResolveInfo;
use GraphQL\Type\Definition\Type;
use Rebing\GraphQL\Support\Facades\GraphQL;
use Rebing\GraphQL\Support\Mutation;
use Rebing\GraphQL\Support\SelectFields;

class CreatePronosticoMutation extends Mutation
{
    protected $attributes = [
        'name' => 'createPronostico',
        'description' => 'A mutation'
    ];

    public function type(): Type
    {
        return GraphQL::type('Pronostico');
    }

    public function args(): array
    {
        return [
            'fecha' => [
                'name' => 'fecha',
                'type' => Type::nonNull(Type::string()),
            ],
            'cantidad_estimada' => [
                'name' => 'cantidad_estimada',
                'type' => Type::nonNull(Type::int()),
            ],
        ];
    }

    public function resolve($root, array $args, $context, ResolveInfo $resolveInfo, Closure $getSelectFields)
    {
        $fields = $getSelectFields();
        $select = $fields->getSelect();
        $with = $fields->getRelations();
        $pronostico = Pronostico::create([
            'fecha' => $args['fecha'],
            'cantidad_estimada' => $args['cantidad_estimada'],
        ]);
        return $pronostico;
    }
}
